package com.app.SpringSecurityApp;

import com.app.SpringSecurityApp.persistence.entity.PermissionEntity;
import com.app.SpringSecurityApp.persistence.entity.RoleEntity;
import com.app.SpringSecurityApp.persistence.entity.RoleEnum;
import com.app.SpringSecurityApp.persistence.entity.UserEntity;
import com.app.SpringSecurityApp.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			/*CREATE PERMISSIONS*/
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();
			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();
			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();
			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();


			/*CREATE ROLES*/
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionEntity(Set.of(createPermission, readPermission,updatePermission,deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionEntity(Set.of(createPermission, readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionEntity(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionEntity(Set.of(createPermission, readPermission,updatePermission,deletePermission,refactorPermission))
					.build();

			/*CREATE USERS*/
			UserEntity userSantiago = UserEntity.builder()
					.username("santiago")
					.password("$2a$10$YdUv1EngtlVMwlQyNDo7a.Eo5dZdEWhUWPpefXfMc5PsrY5Y.yItS")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserEntity userDaniel = UserEntity.builder()
					.username("daniel")
					.password("$2a$10$YdUv1EngtlVMwlQyNDo7a.Eo5dZdEWhUWPpefXfMc5PsrY5Y.yItS")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserEntity userAndrea = UserEntity.builder()
					.username("andrea")
					.password("$2a$10$YdUv1EngtlVMwlQyNDo7a.Eo5dZdEWhUWPpefXfMc5PsrY5Y.yItS")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();
			UserEntity userAnyi = UserEntity.builder()
					.username("anyi")
					.password("$2a$10$YdUv1EngtlVMwlQyNDo7a.Eo5dZdEWhUWPpefXfMc5PsrY5Y.yItS")
					.isEnable(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userSantiago,userDaniel,userAndrea,userAnyi));


		};
	}

}
