package com.example.webcty.services.impl;

import com.example.webcty.dto.request.AboutUsIntroRequest;
import com.example.webcty.dto.response.AboutUsIntroResponse;
import com.example.webcty.entities.aboutUsPage.AboutUsIntro;
import com.example.webcty.mapper.AboutUsIntroMapper;
import com.example.webcty.repositories.AboutUsIntroRepository;
import com.example.webcty.services.AboutUsIntroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutUsIntroServiceImpl implements AboutUsIntroService {
    private final AboutUsIntroRepository aboutUsIntroRepository;
    private final AboutUsIntroMapper aboutUsIntroMapper;

    @Autowired
    public AboutUsIntroServiceImpl(AboutUsIntroRepository aboutUsIntroRepository, AboutUsIntroMapper aboutUsIntroMapper) {
        this.aboutUsIntroRepository = aboutUsIntroRepository;
        this.aboutUsIntroMapper = aboutUsIntroMapper;
    }

    @Override
    public List<AboutUsIntroResponse> getAllAboutUsIntro() {
        return aboutUsIntroRepository.findAll().stream()
                .map(aboutUsIntroMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AboutUsIntroResponse getAboutUsIntroById(Long id) {
        AboutUsIntro aboutUsIntro = aboutUsIntroRepository.findById(id).orElse(null);
        return aboutUsIntro != null ? aboutUsIntroMapper.toResponseDTO(aboutUsIntro) : null;
    }

    @Override
    @Transactional
    public AboutUsIntroResponse createAboutUsIntro(AboutUsIntroRequest aboutUsDTO) {
        aboutUsIntroRepository.deleteAll();
        AboutUsIntro aboutUsIntro = aboutUsIntroMapper.toEntity(aboutUsDTO);
        AboutUsIntro savedAboutUsIntro = aboutUsIntroRepository.save(aboutUsIntro);
        return aboutUsIntroMapper.toResponseDTO(savedAboutUsIntro);
    }

    @Override
    public AboutUsIntroResponse updateAboutUsIntro(Long id, AboutUsIntroRequest updatedAboutUsIntroDTO) {
        AboutUsIntro aboutUsIntro = aboutUsIntroRepository.findById(id).orElse(null);
        if (aboutUsIntro != null) {
            aboutUsIntro.setTitle(updatedAboutUsIntroDTO.getTitle());
            aboutUsIntro.setDescription(updatedAboutUsIntroDTO.getDescription());
            aboutUsIntro.setImage(updatedAboutUsIntroDTO.getImage());
            AboutUsIntro updatedAboutUsIntro = aboutUsIntroRepository.save(aboutUsIntro);
            return aboutUsIntroMapper.toResponseDTO(updatedAboutUsIntro);
        }
        return null;
    }

    @Override
    public void deleteAboutUsIntro(Long id) {
        aboutUsIntroRepository.deleteById(id);
    }
}
