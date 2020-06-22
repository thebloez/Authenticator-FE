package com.lab.fe.authenticator.repository;

import com.lab.fe.authenticator.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepos extends JpaRepository<Merchant, String> {
}
