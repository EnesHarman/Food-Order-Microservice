package com.enesharman.guipanel.controller;

import com.enesharman.guipanel.service.PanelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gui-panel")
public class PanelController {
    private final PanelService panelService;

    public PanelController(PanelService panelService) {
        this.panelService = panelService;
    }


}
