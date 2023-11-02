package com.zjx.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Nutrition {
    private String production_batches;
    private List<NutritionComposition> compositionList;
    private String food_appraisal_agency;//鉴定机构
    private Date appraisal_time; //鉴定时间

    @Setter
    @Getter
    public static class NutritionComposition{
        String name;
        float dosage;

        public NutritionComposition(String name, float dosage) {
            this.name = name;
            this.dosage = dosage;
        }
    }

    public Nutrition(String production_batches, List<NutritionComposition> compositionList, String food_appraisal_agency, Date appraisal_time) {
        this.production_batches = production_batches;
        this.compositionList = compositionList;
        this.food_appraisal_agency = food_appraisal_agency;
        this.appraisal_time = appraisal_time;
    }
}
