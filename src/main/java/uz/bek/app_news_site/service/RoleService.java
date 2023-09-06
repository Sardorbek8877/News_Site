package uz.bek.app_news_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bek.app_news_site.entity.Role;
import uz.bek.app_news_site.payload.ApiResponse;
import uz.bek.app_news_site.payload.RoleDto;
import uz.bek.app_news_site.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse addRole(RoleDto roleDto){
        boolean existsByName = roleRepository.existsByName(roleDto.getName());
        if (existsByName)
            return new ApiResponse("Role already exist", false);
        Role role = new Role(
                roleDto.getName(),
                roleDto.getRoleList(),
                roleDto.getDescription()
        );
        roleRepository.save(role);
        return new ApiResponse("Role added", true);
    }

    public ApiResponse editRole(Long id, RoleDto roleDto) {
        return null;
    }
}
