package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.PassiveHouse;
import kamenov.naturalnaturefinalapp.repositories.PassiveHouseRepository;
import kamenov.naturalnaturefinalapp.service.PassiveHouseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassiveHouseServiceImpl implements PassiveHouseService {
    private final PassiveHouseRepository passiveHouseRepository;

    public PassiveHouseServiceImpl(PassiveHouseRepository passiveHouseRepository) {
        this.passiveHouseRepository = passiveHouseRepository;
    }

//    @Override
//    public List<PassiveHouse> getAllPassiveHouses() {
//        return passiveHouseRepository.findAll();
//    }
//
//    @Override
//    public List<PassiveHouse> getPassiveHousesByCategory(String category) {
//        return passiveHouseRepository.findByCategory(category);
//    }

    @Override
    public List<PassiveHouse> getAllPassiveHouses() {
        List<PassiveHouse> houses = passiveHouseRepository.findAll();
        System.out.println("PassiveHouseServiceImpl: All Passive Houses: " + houses);
        return houses;
    }

    @Override
    public List<PassiveHouse> getPassiveHousesByCategory(String category) {
        List<PassiveHouse> houses = passiveHouseRepository.findByCategory(category);
        System.out.println("PassiveHouseServiceImpl: Passive Houses for category " + category + ": " + houses);
        return houses;
    }

    @Override
    public void savePassiveHouse(PassiveHouse passiveHouse) {
        System.out.println("PassiveHouseServiceImpl: Saving passive house: " + passiveHouse.getTitle());
        passiveHouseRepository.save(passiveHouse);
        System.out.println("PassiveHouseServiceImpl: Passive House saved. Total count: " + passiveHouseRepository.count());
    }

//    @PostConstruct
//    public void initPassiveHouses() {
//        if (passiveHouseRepository.count() == 0) {
//            passiveHouseRepository.saveAll(List.of(
//                    // Energy Efficiency
//                    new PassiveHouse(
//                            "Understanding Eco-Friendly Homes: A Comprehensive Guide",
//                            "Eco-friendly homes are designed to minimize environmental impact through energy efficiency," +
//                                    " sustainable materials, and renewable energy sources. Learn the basics of passive house design.",
//                            "Energy Efficiency",
//                            "/images/house-5.jpg",
//                            "https://www.youtube.com/embed/eRBNnfXXF4w"
//                    ),
//                    new PassiveHouse(
//                            "Principles of Sustainable Home Design for Your Next Home Improvement",
//                            "Sustainable home design focuses on reducing energy consumption, using natural light, and incorporating eco-friendly materials. Discover key principles to apply in your next project.",
//                            "Energy Efficiency",
//                            "/images/sustainable-design.jpg",
//                            "https://www.youtube.com/embed/Fezmkc9X3eE"
//                    ),
//                    new PassiveHouse(
//                            "Building the Passive House: Steps to Achieve an Eco-Friendly House",
//                            "Building a passive house involves careful planning, from site selection to insulation. Follow these steps to create an energy-efficient home.",
//                            "Energy Efficiency",
//                            "/images/passive-house-build.jpg",
//                            "https://www.youtube.com/embed/passive-house-build-video"
//                    ),
////                    water
//
//                    new PassiveHouse(
//                            "Advanced Water Conservation Methods",
//                            "Explore advanced methods like greywater recycling and smart irrigation systems to further reduce water usage.",
//                            "Water Conservation",
//                            "/images/greywater-system.jpg",
//                            null
//                    ),
//                    // Solar Power Systems
//                    new PassiveHouse(
//                            "An Insight into Green Home: Environmentally Friendly Approaches in House Construction",
//                            "Solar power systems are a cornerstone of green homes. Learn how to integrate solar panels into your home for sustainable energy.",
//                            "Solar Power Systems",
//                            "/images/solar-panels.jpg",
//                            "https://www.youtube.com/embed/Fezmkc9X3eE"
//                    ),
//                    new PassiveHouse(
//                            "Going Beyond the Basics: Insulation, Energy Efficiency, and Ways to Heat and Cool Your Eco-Home",
//                            "Solar energy can be used for heating and cooling. Explore advanced techniques to maximize energy efficiency in your eco-home.",
//                            "Solar Power Systems",
//                            "/images/solar-heating.jpg",
//                            "https://www.youtube.com/embed/solar-heating-video"
//                    ),
//
//                    // Water Conservation
//                    new PassiveHouse(
//                            "Popular Sustainable Living Techniques: Energy Efficient Appliances, Rainwater Collection, and Renewable Energy Use in Homes",
//                            "Rainwater collection systems can significantly reduce water usage. Learn how to implement them in your home.",
//                            "Water Conservation",
//                            "/images/rainwater-collection.jpg",
//                            "https://www.youtube.com/embed/Fezmkc9X3eE"
//                    ),
//                    new PassiveHouse(
//                            "Transition into an Eco-Friendly Building: Make Your Home More Sustainable with Energy Star-rated Appliances and Fixtures",
//                            "Water-saving fixtures and Energy Star-rated appliances can transform your home into a sustainable haven. Discover the best options.",
//                            "Water Conservation",
//                            "/images/water-saving-fixtures.jpg",
//                            "https://www.youtube.com/embed/water-saving-video"
//                    ),
//
//                    // Wind Turbines
//                    new PassiveHouse(
//                            "Making the Smart Choice: Leverage Prefab Homes and Eco-Friendly Building Materials for Reduced Energy Use",
//                            "Wind turbines can provide renewable energy for prefab homes. Learn how to integrate them into your eco-friendly design.",
//                            "Wind Turbines",
//                            "/images/wind-turbine.jpg",
//                            "https://www.youtube.com/embed/Fezmkc9X3eE"
//                    ),
//                    new PassiveHouse(
//                            "Reconfiguring Existing Homes: Ideas to Transform Your Home into an Energy-Efficient One",
//                            "Retrofitting your home with wind turbines and other renewable energy sources can make it more sustainable. Get practical ideas here.",
//                            "Wind Turbines",
//                            "/images/wind-retrofit.jpg",
//                            "https://www.youtube.com/embed/wind-retrofit-video"
//                    ),
//                    new PassiveHouse(
//                            "Earth-friendly Materials for Friendly Homes: Natural Materials in the Construction of Environmentally Friendly Homes",
//                            "Using natural materials alongside wind energy can create a truly eco-friendly home. Explore the best materials to use.",
//                            "Wind Turbines",
//                            "/images/natural-materials.jpg",
//                            "https://www.youtube.com/embed/Fezmkc9X3eE"
//                    )
//            ));
//            System.out.println("Passive Houses initialized.");
//        }
//
//    }

}
