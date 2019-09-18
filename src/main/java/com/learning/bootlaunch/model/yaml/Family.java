package com.learning.bootlaunch.model.yaml;

import com.learning.bootlaunch.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
public class Family {

//    @Value("${family.family-name}")
    @NotBlank
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;

}
