package uz.bek.app_news_site.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bek.app_news_site.payload.ApiResponse;
import uz.bek.app_news_site.payload.RoleDto;
import uz.bek.app_news_site.service.RoleService;
import uz.bek.app_news_site.service.UserService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping
    public HttpEntity<?> addRole(@Valid @RequestBody RoleDto roleDto){
        ApiResponse apiResponse = roleService.addRole(roleDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);
    }

}
