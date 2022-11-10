package com.baseproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.baseproject.enumeration.Profiles;
import com.baseproject.enumeration.Roles;
import com.baseproject.model.Profile;
import com.baseproject.model.ProfileRepository;
import com.baseproject.model.Role;
import com.baseproject.model.RoleRepository;
import com.baseproject.model.User;
import com.baseproject.model.UserRepository;
import com.baseproject.enumeration.FuncionalidadeEnum;
import com.baseproject.enumeration.ParametrosEnum;
import com.baseproject.model.Funcionalidade;
import com.baseproject.model.FuncionalidadeRepository;
import com.baseproject.model.Parametro;
import com.baseproject.model.ParametroRepository;
import com.baseproject.util.ServiceUtil;

@Service
public class InitService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    FuncionalidadeRepository funcRepository;

    @Autowired
    ParametroRepository prmRepository;

    @Autowired
    Environment env;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @Value("${admin.name}")
    private String adminName;

    public void init() {
        createRoles();
        createProfiles();
        createParameters();
        createUserAdmin();
    }

    private void createUserAdmin() {
        boolean existsByUsername = userRepository.existsByUsername(adminUsername);
        String adminPswrd = passwordEncoder.encode(adminPassword);

        if (!existsByUsername) {
            User adminUser = new User();
            adminUser.setName(adminName);
            adminUser.setUsername(adminUsername);
            adminUser.setPassword(adminPswrd);
            adminUser.setUuid(ServiceUtil.generateUuid());
            adminUser.setProfiles(new ArrayList<>());
            adminUser.getProfiles().addAll(profileRepository.findAll());
            userRepository.save(adminUser);
        }

    }

    private void createRoles() {
        // INSERT ROLES
        for (Roles rn : Roles.values()) {
            Role bdRole = roleRepository.findByName(rn);
            if (null == bdRole) {
                Role role = new Role();
                role.setName(rn);
                role.setDescription(rn.getDescription());
                roleRepository.save(role);
            }
        }
    }

    private void createProfiles() {
        // INSERT PROFILES
        for (Profiles p : Profiles.values()) {
            Profile profile = profileRepository.findProfileByName(p.getName());
            Roles[] roles = null;
            if (p.isAllRoles()) {
                roles = Roles.values();
            } else {
                roles = p.getRoles();
            }
            if (null == profile) {
                profile = new Profile();
                profile.setDescription(p.getDescription());
                profile.setName(p.getName());
                profile.setUuid(ServiceUtil.generateUuid());
                for (Roles r : roles) {
                    Role bdRole = roleRepository.findByName(r);
                    profile.getRoles().add(bdRole);
                }
            } else {
                for (Roles ro : roles) {
                    Role rolePerfil = profile.getRoles().stream().filter(r -> ro.name().equals(r.getName().toString())).findAny().orElse(null);
                    if (rolePerfil == null) {
                        Role bdRole = roleRepository.findByName(ro);
                        profile.getRoles().add(bdRole);
                    }
                }
            }
            profileRepository.save(profile);
        }
    }

    private void createParameters() {
        // INSERT FUNCIONALIDADES
        for (FuncionalidadeEnum rn : FuncionalidadeEnum.values()) {
            Funcionalidade bdFunc = funcRepository.findByNome(rn.getNome());
            if (null == bdFunc) {
                Funcionalidade func = new Funcionalidade();
                func.setNome(rn.getNome());
                func.setDescricao(rn.getDescricao());
                func.setUuid(ServiceUtil.generateUuid());
                funcRepository.save(func);
            }
        }

        // INSERT PARAMETROS
        for (ParametrosEnum rn : ParametrosEnum.values()) {
            Funcionalidade bdFunc = funcRepository.findByNome(rn.getFuncionalidade());
            List<Parametro> parametros = bdFunc.getParametros();
            boolean cadastrado = false;
            for (Parametro p : parametros) {
                if (cadastrado) {
                    continue;
                }
                cadastrado = p.getNome().equals(rn.toString());
            }
            if (!cadastrado) {
                Parametro prm = new Parametro();
                prm.setNome(rn.toString());
                prm.setValor(rn.getValor());
                prm.setFuncionalidade(bdFunc);
                prm.setUuid(ServiceUtil.generateUuid());
                prmRepository.save(prm);
            }
        }
    }

}
