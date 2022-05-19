package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.UserAccountEnitity;

public interface UserAccountMasterRepo extends JpaRepository<UserAccountEnitity, Integer> {
//select * from user accounts where email=? and user_pwd=?
	public UserAccountEnitity findByEmailAndPazzword(String email, String pwd);

	public UserAccountEnitity findByEmail(String email);

}
