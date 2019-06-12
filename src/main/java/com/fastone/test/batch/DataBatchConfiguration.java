package com.fastone.test.batch;

import com.fastone.test.model.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

@Configuration
@EnableBatchProcessing
@Slf4j
public class DataBatchConfiguration {


    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Resource
    private JobListener jobListener;

    @Bean
    public Job dataHandleJob() {
        return jobBuilderFactory.get("dataHandleJob")
                .incrementer(new RunIdIncrementer())
                .start(handleDataStep())
                .listener(jobListener)
                .build();
    }

    @Bean
    public Step handleDataStep() {
        return stepBuilderFactory.get("getData").<People, People>chunk(100).faultTolerant().retryLimit(3)
                .retry(Exception.class).skipLimit(100).skip(Exception.class)
                .reader(getDataReader())
                .processor(getDataProcessor())
                .writer(getDataWriter())
                .build();
    }

    @Bean
    public ItemReader<? extends People> getDataReader() {
        FlatFileItemReader<People> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("static/people.csv"));
        reader.setLineMapper(new DefaultLineMapper<>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"id", "name", "age", "company"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
                    {
                        setTargetType(People.class);
                    }
                });
            }
        });
        return reader;
    }


    @Bean
    public ItemProcessor<? super People, ? extends People> getDataProcessor() {
        return new ItemProcessor<People, People>() {
            @Override
            public People process(People people) throws Exception {
                log.info("processor data : " + people.toString());
                if (people.getAge() > 25) {
                    people.setCompany("IBM");
                }
                return people;
            }
        };
    }

    @Bean
    public ItemWriter<? super People> getDataWriter() {
        return list -> {
            for (People p :list) {
                log.info("write data : " + p.toString());
            }
        };
    }


}
