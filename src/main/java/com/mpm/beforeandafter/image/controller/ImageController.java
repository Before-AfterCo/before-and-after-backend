package com.mpm.beforeandafter.image.controller;

import com.mpm.beforeandafter.image.dto.CreateImageRequestDTO;
import com.mpm.beforeandafter.image.dto.CreateImageResponseDTO;
import com.mpm.beforeandafter.image.dto.ImageFilterRequestDTO;
import com.mpm.beforeandafter.image.dto.ImageFilterResponseDTO;
import com.mpm.beforeandafter.image.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public CreateImageResponseDTO createImage(@RequestBody CreateImageRequestDTO request) {
        return imageService.createImage(request);
    }

//    @GetMapping("/categories/{id}/city")
//    public List<GetImagesByCategoryAndCityResponse> getImagesByCategoryAndCity(
//            @PathVariable("id") Long categoryId,
//            @RequestParam(name = "cityName", required = false) String cityName) {
//        log.debug("Get all images by category: {} and city name: {}", categoryId, cityName);
//        List<Image> images = imageService.getImagesByCategoryAndCity(categoryId, cityName);
//        log.info("Images by category and city: {}", images);
//        List<GetImagesByCategoryAndCityResponse> imagesByCategoryAndCity = new ArrayList<>();
//        for (Image image : images) {
//            GetImagesByCategoryAndCityResponse imageByCategoryAndCity = GetImagesByCategoryAndCityResponse.map(image);
//            imagesByCategoryAndCity.add(imageByCategoryAndCity);
//        }
//        return imagesByCategoryAndCity;
//    }

    @GetMapping
    public Set<ImageFilterResponseDTO> getAllImagesByDynamicFilter(@RequestBody ImageFilterRequestDTO request){
        return imageService.getImagesByDynamicFilter(request);
    }
}
