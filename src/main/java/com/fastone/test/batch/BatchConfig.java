package com.fastone.test.batch;

import com.fastone.test.model.People;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.xml.validation.Validator;

@Configuration
@EnableBatchProcessing
public class BatchConfig {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @PersistenceUnit
    private EntityManagerFactory emf;


    /**
     * ItemReader 定义 ，用来读取文件
     * 1.使用FlatFileItemReader读取文件
     * 2.使用FlatFileItemReader的setResource方法设置csv文件的路径
     * 3.对此csv文件的数据和模型类做对应映射
     * @return
     */
    @Bean
    public ItemReader<People> reader(){
        FlatFileItemReader<People> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("static/people.csv"));
        reader.setLineMapper(new DefaultLineMapper<People>(){
            {
                setLineTokenizer(new DelimitedLineTokenizer(){
                    {
                        setNames(new String[]{"id","name","age","company"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<>(){
                    {
                        setTargetType(People.class);
                    }
                });
            }
        });
        return reader;
    }



}
