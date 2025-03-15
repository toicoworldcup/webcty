package com.example.webcty.services;

import com.example.webcty.entities.AboutUs;
import com.example.webcty.repositories.AboutUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutUsService {
    @Autowired
    private AboutUsRepository aboutUsRepository;

    public List<AboutUs> getAllAboutUs() {
        return aboutUsRepository.findAll();
    }

    public AboutUs getAboutUsById(Long id) {
        return aboutUsRepository.findById(id).orElse(null);
    }

    public AboutUs createAboutUs(AboutUs aboutUs) {
        return aboutUsRepository.save(aboutUs);
    }

    public AboutUs updateAboutUs(Long id, AboutUs updatedAboutUs) {
        AboutUs aboutUs = getAboutUsById(id);
        aboutUs.setTitle(updatedAboutUs.getTitle());
        aboutUs.setContent(updatedAboutUs.getContent());
        aboutUs.setModifiedBy(updatedAboutUs.getModifiedBy());
        return aboutUsRepository.save(aboutUs);
    }

    public void deleteAboutUs(Long id) {
        aboutUsRepository.deleteById(id);
    }
}
