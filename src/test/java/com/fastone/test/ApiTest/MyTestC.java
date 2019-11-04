package com.fastone.test.ApiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastone.test.dto.FilterDTO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestC {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

    @Test
    public void extractFilters() throws IOException {
        String filtersString = "[[\"name\",\"ilike\",\"%test%\"],[\"appName\",\"ilike\",\"%My%\"],[\"username\",\"ilike\",\"%admin%\"]]";

        List<List<Object>> filterList = null;
        filterList = mapper.readValue(filtersString, new TypeReference<List<List<Object>>>() {
        });
//        System.out.println(filterList);

        List<FilterDTO> filters = Lists.newArrayList();
        if (filterList != null) {
            filters = filterList.stream().map(x -> {
                if (x.size() == 3) {
                    return new FilterDTO("" + x.get(0), "" + x.get(1), x.get(2));
                }
                return null;
            }).collect(Collectors.toList());
        }
        System.out.println(filters);

    }

    @Test
    public void  generateFiltersString() {
        List<FilterDTO> filters = new ArrayList<>();
        filters.add(new FilterDTO("name","ilike","%my%"));
        List<List<Object>> filtersList = filters.stream().map(filter -> Arrays.asList(filter.getField(), filter.getOperator(), filter.getValue())).collect(Collectors.toList());
        try {
            System.out.println(mapper.writeValueAsString(filtersList));
        } catch (JsonProcessingException e) {
            log.error("Unexpected JSON error", e);
        }
    }

}
