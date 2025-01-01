package com.example.plantdiseasedetector.data

import com.example.plantdiseasedetector.R
import com.example.plantdiseasedetector.domain.KnowledgeCategory

class DataSourceClimateInfo {
    fun loadClimateInfo(): List<KnowledgeCategory> {
        return listOf<KnowledgeCategory>(
            //1
            KnowledgeCategory(
                title = R.string.wheat_name,
                climateInfo = R.string.wheat_climate,
                soilInfo = R.string.wheat_soil,
                disease1Info = R.string.wheat_disease1,
                disease1Prevention = R.string.wheat_disease1_prevention,
                disease2Info = R.string.wheat_disease2,
                disease2Prevention = R.string.wheat_disease2_prevention,
                category_image = R.drawable.wheat,
                id = 1
            ),
            //2
            KnowledgeCategory(
                title = R.string.rice_name,
                climateInfo = R.string.rice_climate,
                soilInfo = R.string.rice_soil,
                disease1Info = R.string.rice_disease1,
                disease1Prevention = R.string.rice_disease1_prevention,
                disease2Info = R.string.rice_disease2,
                disease2Prevention = R.string.rice_disease2_prevention,
                category_image = R.drawable.rice,
                id = 2
            ),
            //3
            KnowledgeCategory(
                title = R.string.maize_name,
                climateInfo = R.string.maize_climate,
                soilInfo = R.string.maize_soil,
                disease1Info = R.string.maize_disease1,
                disease1Prevention = R.string.maize_disease1_prevention,
                disease2Info = R.string.maize_disease2,
                disease2Prevention = R.string.maize_disease2_prevention,
                category_image = R.drawable.maize,
                id = 3
            ),
            //4
            KnowledgeCategory(
                title = R.string.barley_name,
                climateInfo = R.string.barley_climate,
                soilInfo = R.string.barley_soil,
                disease1Info = R.string.barley_disease1,
                disease1Prevention = R.string.barley_disease1_prevention,
                disease2Info = R.string.barley_disease2,
                disease2Prevention = R.string.barley_disease2_prevention,
                category_image = R.drawable.barley,
                id = 4
            ),
            //5
            KnowledgeCategory(
                title = R.string.millet_name,
                climateInfo = R.string.millet_climate,
                soilInfo = R.string.millet_soil,
                disease1Info = R.string.millet_disease1,
                disease1Prevention = R.string.millet_disease1_prevention,
                disease2Info = R.string.millet_disease2,
                disease2Prevention = R.string.millet_disease2_prevention,
                category_image = R.drawable.millet,
                id = 5
            ),
            //6
            KnowledgeCategory(
                title = R.string.sorghum_name,
                climateInfo = R.string.sorghum_climate,
                soilInfo = R.string.sorghum_soil,
                disease1Info = R.string.sorghum_disease1,
                disease1Prevention = R.string.sorghum_disease1_prevention,
                disease2Info = R.string.sorghum_disease2,
                disease2Prevention = R.string.sorghum_disease2_prevention,
                category_image = R.drawable.sorghum,
                id = 6
            ),
            //8
            KnowledgeCategory(
                title = R.string.potato_name,
                climateInfo = R.string.potato_climate,
                soilInfo = R.string.potato_soil,
                disease1Info = R.string.potato_disease1,
                disease1Prevention = R.string.potato_disease1_prevention,
                disease2Info = R.string.potato_disease2,
                disease2Prevention = R.string.potato_disease2_prevention,
                category_image = R.drawable.potato,
                id = 8
            ),
            //9
            KnowledgeCategory(
                title = R.string.cucumber_name,
                climateInfo = R.string.cucumber_climate,
                soilInfo = R.string.cucumber_soil,
                disease1Info = R.string.cucumber_disease1,
                disease1Prevention = R.string.cucumber_disease1_prevention,
                disease2Info = R.string.cucumber_disease2,
                disease2Prevention = R.string.cucumber_disease2_prevention,
                category_image = R.drawable.cucumber,
                id = 9
            ),
            //10
            KnowledgeCategory(
                title = R.string.lettuce_name,
                climateInfo = R.string.lettuce_climate,
                soilInfo = R.string.lettuce_soil,
                disease1Info = R.string.lettuce_disease1,
                disease1Prevention = R.string.lettuce_disease1_prevention,
                disease2Info = R.string.lettuce_disease2,
                disease2Prevention = R.string.lettuce_disease2_prevention,
                category_image = R.drawable.lettuce,
                id = 10
            ),
            //11
            KnowledgeCategory(
                title = R.string.tomato_name,
                climateInfo = R.string.wheat_climate,
                soilInfo = R.string.wheat_soil,
                disease1Info = R.string.wheat_disease1,
                disease1Prevention = R.string.wheat_disease1_prevention,
                disease2Info = R.string.wheat_disease2,
                disease2Prevention = R.string.wheat_disease2_prevention,
                category_image = R.drawable.tomato,
                id = 11
            ),
            //12
            KnowledgeCategory(
                title = R.string.carrot_name,
                climateInfo = R.string.carrot_climate,
                soilInfo = R.string.carrot_soil,
                disease1Info = R.string.carrot_disease1,
                disease1Prevention = R.string.carrot_disease1_prevention,
                disease2Info = R.string.carrot_disease2,
                disease2Prevention = R.string.carrot_disease2_prevention,
                category_image = R.drawable.carrot,
                id = 12
            ),
            //13
            KnowledgeCategory(
                title = R.string.sugarcane_name,
                climateInfo = R.string.sugarcane_climate,
                soilInfo = R.string.sugarcane_soil,
                disease1Info = R.string.sugarcane_disease1,
                disease1Prevention = R.string.sugarcane_disease1_prevention,
                disease2Info = R.string.sugarcane_disease2,
                disease2Prevention = R.string.sugarcane_disease2_prevention,
                category_image = R.drawable.sugarcane,
                id = 13
            ),
            //14
            KnowledgeCategory(
                title = R.string.spinach_name,
                climateInfo = R.string.spinach_climate,
                soilInfo = R.string.spinach_soil,
                disease1Info = R.string.spinach_disease1,
                disease1Prevention = R.string.spinach_disease1_prevention,
                disease2Info = R.string.spinach_disease2,
                disease2Prevention = R.string.spinach_disease2_prevention,
                category_image = R.drawable.spinach,
                id = 14
            ),
            //15
            KnowledgeCategory(
                title = R.string.pea_name,
                climateInfo = R.string.pea_climate,
                soilInfo = R.string.pea_soil,
                disease1Info = R.string.pea_disease1,
                disease1Prevention = R.string.pea_disease1_prevention,
                disease2Info = R.string.pea_disease2,
                disease2Prevention = R.string.pea_disease2_prevention,
                category_image = R.drawable.pea,
                id = 15
            ),
            //16
            KnowledgeCategory(
                title = R.string.onion_name,
                climateInfo = R.string.onion_climate,
                soilInfo = R.string.onion_soil,
                disease1Info = R.string.onion_disease1,
                disease1Prevention = R.string.onion_disease1_prevention,
                disease2Info = R.string.onion_disease2,
                disease2Prevention = R.string.onion_disease2_prevention,
                category_image = R.drawable.onion,
                id = 16
            ),
            //17
            KnowledgeCategory(
                title = R.string.garlic_name,
                climateInfo = R.string.garlic_climate,
                soilInfo = R.string.garlic_soil,
                disease1Info = R.string.garlic_disease1,
                disease1Prevention = R.string.garlic_disease1_prevention,
                disease2Info = R.string.garlic_disease2,
                disease2Prevention = R.string.garlic_disease2_prevention,
                category_image = R.drawable.garlic,
                id = 17
            ),
            //18
            KnowledgeCategory(
                title = R.string.eggplant_name,
                climateInfo = R.string.eggplant_climate,
                soilInfo = R.string.eggplant_soil,
                disease1Info = R.string.eggplant_disease1,
                disease1Prevention = R.string.eggplant_disease1_prevention,
                disease2Info = R.string.eggplant_disease2,
                disease2Prevention = R.string.eggplant_disease2_prevention,
                category_image = R.drawable.eggplant,
                id = 18
            ),
            //19
            KnowledgeCategory(
                title = R.string.bell_pepper_name,
                climateInfo = R.string.bell_pepper_climate,
                soilInfo = R.string.bell_pepper_soil,
                disease1Info = R.string.bell_pepper_disease1,
                disease1Prevention = R.string.bell_pepper_disease1_prevention,
                disease2Info = R.string.bell_pepper_disease2,
                disease2Prevention = R.string.bell_pepper_disease2_prevention,
                category_image = R.drawable.bell_pepper,
                id = 19
            ),
            //20
            KnowledgeCategory(
                title = R.string.cabbage_name,
                climateInfo = R.string.cabbage_climate,
                soilInfo = R.string.cabbage_soil,
                disease1Info = R.string.cabbage_disease1,
                disease1Prevention = R.string.cabbage_disease1_prevention,
                disease2Info = R.string.cabbage_disease2,
                disease2Prevention = R.string.cabbage_disease2_prevention,
                category_image = R.drawable.cabbage,
                id = 20
            ),
            //21
            KnowledgeCategory(
                title = R.string.cauliflower_name,
                climateInfo = R.string.cauliflower_climate,
                soilInfo = R.string.cauliflower_soil,
                disease1Info = R.string.cauliflower_disease1,
                disease1Prevention = R.string.cauliflower_disease1_prevention,
                disease2Info = R.string.cauliflower_disease2,
                disease2Prevention = R.string.cauliflower_disease2_prevention,
                category_image = R.drawable.cauliflower,
                id = 21
            ),
            //22
            KnowledgeCategory(
                title = R.string.lettuce_name,
                climateInfo = R.string.lettuce_climate,
                soilInfo = R.string.lettuce_soil,
                disease1Info = R.string.lettuce_disease1,
                disease1Prevention = R.string.lettuce_disease1_prevention,
                disease2Info = R.string.lettuce_disease2,
                disease2Prevention = R.string.lettuce_disease2_prevention,
                category_image = R.drawable.lettuce,
                id = 22
            ),
            //24
            KnowledgeCategory(
                title = R.string.broccoli_name,
                climateInfo = R.string.broccoli_climate,
                soilInfo = R.string.broccoli_soil,
                disease1Info = R.string.broccoli_disease1,
                disease1Prevention = R.string.broccoli_disease1_prevention,
                disease2Info = R.string.broccoli_disease2,
                disease2Prevention = R.string.broccoli_disease2_prevention,
                category_image = R.drawable.broccoli,
                id = 24
            ),
            //25
            KnowledgeCategory(
                title = R.string.zucchini_name,
                climateInfo = R.string.zucchini_climate,
                soilInfo = R.string.zucchini_soil,
                disease1Info = R.string.zucchini_disease1,
                disease1Prevention = R.string.zucchini_disease1_prevention,
                disease2Info = R.string.zucchini_disease2,
                disease2Prevention = R.string.zucchini_disease2_prevention,
                category_image = R.drawable.zucchini,
                id = 25
            ),
            //26
            KnowledgeCategory(
                title = R.string.pumpkin_name,
                climateInfo = R.string.pumpkin_climate,
                soilInfo = R.string.pumpkin_soil,
                disease1Info = R.string.pumpkin_disease1,
                disease1Prevention = R.string.pumpkin_disease1_prevention,
                disease2Info = R.string.pumpkin_disease2,
                disease2Prevention = R.string.pumpkin_disease2_prevention,
                category_image = R.drawable.pumpkin,
                id = 26
            ),
            //27
            KnowledgeCategory(
                title = R.string.sweet_corn_name,
                climateInfo = R.string.sweet_corn_climate,
                soilInfo = R.string.sweet_corn_soil,
                disease1Info = R.string.sweet_corn_disease1,
                disease1Prevention = R.string.sweet_corn_disease1_prevention,
                disease2Info = R.string.sweet_corn_disease2,
                disease2Prevention = R.string.sweet_corn_disease2_prevention,
                category_image = R.drawable.sweet_corn,
                id = 27
            ),
            //28
            KnowledgeCategory(
                title = R.string.watermelon_name,
                climateInfo = R.string.watermelon_climate,
                soilInfo = R.string.watermelon_soil,
                disease1Info = R.string.watermelon_disease1,
                disease1Prevention = R.string.watermelon_disease1_prevention,
                disease2Info = R.string.watermelon_disease2,
                disease2Prevention = R.string.watermelon_disease2_prevention,
                category_image = R.drawable.watermelon,
                id = 28
            ),
            //29
            KnowledgeCategory(
                title = R.string.soybean_name,
                climateInfo = R.string.soybean_climate,
                soilInfo = R.string.soybean_soil,
                disease1Info = R.string.soybean_disease1,
                disease1Prevention = R.string.soybean_disease1_prevention,
                disease2Info = R.string.soybean_disease2,
                disease2Prevention = R.string.soybean_disease2_prevention,
                category_image = R.drawable.soybean,
                id = 29
            ),
            //30
            KnowledgeCategory(
                title = R.string.sunflower_name,
                climateInfo = R.string.sunflower_climate,
                soilInfo = R.string.sunflower_soil,
                disease1Info = R.string.sunflower_disease1,
                disease1Prevention = R.string.sunflower_disease1_prevention,
                disease2Info = R.string.sunflower_disease2,
                disease2Prevention = R.string.sunflower_disease2_prevention,
                category_image = R.drawable.sunflower,
                id = 30
            ),
            //31
            KnowledgeCategory(
                title = R.string.chickpea_name,
                climateInfo = R.string.chickpea_climate,
                soilInfo = R.string.chickpea_soil,
                disease1Info = R.string.chickpea_disease1,
                disease1Prevention = R.string.chickpea_disease1_prevention,
                disease2Info = R.string.chickpea_disease2,
                disease2Prevention = R.string.chickpea_disease2_prevention,
                category_image = R.drawable.chickpea,
                id = 31
            ),
            //32
            KnowledgeCategory(
                title = R.string.apple_name,
                climateInfo = R.string.apple_climate,
                soilInfo = R.string.apple_soil,
                disease1Info = R.string.apple_disease1,
                disease1Prevention = R.string.apple_disease1_prevention,
                disease2Info = R.string.apple_disease2,
                disease2Prevention = R.string.apple_disease2_prevention,
                category_image = R.drawable.apple,
                id = 32
            ),
            //33
            KnowledgeCategory(
                title = R.string.blueberry_name,
                climateInfo = R.string.blueberry_climate,
                soilInfo = R.string.blueberry_soil,
                disease1Info = R.string.blueberry_disease1,
                disease1Prevention = R.string.blueberry_disease1_prevention,
                disease2Info = R.string.blueberry_disease2,
                disease2Prevention = R.string.blueberry_disease2_prevention,
                category_image = R.drawable.blueberry,
                id = 33
            ),
            //34
            KnowledgeCategory(
                title = R.string.cherry_name,
                climateInfo = R.string.cherry_climate,
                soilInfo = R.string.cherry_soil,
                disease1Info = R.string.cherry_disease1,
                disease1Prevention = R.string.cherry_disease1_prevention,
                disease2Info = R.string.cherry_disease2,
                disease2Prevention = R.string.cherry_disease2_prevention,
                category_image = R.drawable.cherry,
                id = 34
            ),
            //35
            KnowledgeCategory(
                title = R.string.corn_name,
                climateInfo = R.string.corn_climate,
                soilInfo = R.string.corn_soil,
                disease1Info = R.string.corn_disease1,
                disease1Prevention = R.string.corn_disease1_prevention,
                disease2Info = R.string.corn_disease2,
                disease2Prevention = R.string.corn_disease2_prevention,
                category_image = R.drawable.corn,
                id = 35
            ),
            //36
            KnowledgeCategory(
                title = R.string.grape_name,
                climateInfo = R.string.grape_climate,
                soilInfo = R.string.grape_soil,
                disease1Info = R.string.grape_disease1,
                disease1Prevention = R.string.grape_disease1_prevention,
                disease2Info = R.string.grape_disease2,
                disease2Prevention = R.string.grape_disease2_prevention,
                category_image = R.drawable.grape,
                id = 36
            ),
            //37
            KnowledgeCategory(
                title = R.string.orange_name,
                climateInfo = R.string.orange_climate,
                soilInfo = R.string.orange_soil,
                disease1Info = R.string.orange_disease1,
                disease1Prevention = R.string.orange_disease1_prevention,
                disease2Info = R.string.orange_disease2,
                disease2Prevention = R.string.orange_disease2_prevention,
                category_image = R.drawable.orange,
                id = 37
            ),
            //38
            KnowledgeCategory(
                title = R.string.peach_name,
                climateInfo = R.string.peach_climate,
                soilInfo = R.string.peach_soil,
                disease1Info = R.string.peach_disease1,
                disease1Prevention = R.string.peach_disease1_prevention,
                disease2Info = R.string.peach_disease2,
                disease2Prevention = R.string.peach_disease2_prevention,
                category_image = R.drawable.peach,
                id = 38
            ),
            //39
            KnowledgeCategory(
                title = R.string.raspberry_name,
                climateInfo = R.string.raspberry_climate,
                soilInfo = R.string.raspberry_soil,
                disease1Info = R.string.raspberry_disease1,
                disease1Prevention = R.string.raspberry_disease1_prevention,
                disease2Info = R.string.raspberry_disease2,
                disease2Prevention = R.string.raspberry_disease2_prevention,
                category_image = R.drawable.raspberry,
                id = 39
            ),
            //40
            KnowledgeCategory(
                title = R.string.squash_name,
                climateInfo = R.string.squash_climate,
                soilInfo = R.string.squash_soil,
                disease1Info = R.string.squash_disease1,
                disease1Prevention = R.string.squash_disease1_prevention,
                disease2Info = R.string.squash_disease2,
                disease2Prevention = R.string.squash_disease2_prevention,
                category_image = R.drawable.squash,
                id = 40
            ),
            //41
            KnowledgeCategory(
                title = R.string.strawberry_name,
                climateInfo = R.string.strawberry_climate,
                soilInfo = R.string.strawberry_soil,
                disease1Info = R.string.strawberry_disease1,
                disease1Prevention = R.string.strawberry_disease1_prevention,
                disease2Info = R.string.strawberry_disease2,
                disease2Prevention = R.string.strawberry_disease2_prevention,
                category_image = R.drawable.strawberry,
                id = 41
            ),
        )
    }
}