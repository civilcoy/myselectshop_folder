package com.sparta.myselectshop_folder.repository;

import com.sparta.myselectshop_folder.entity.Folder;
import com.sparta.myselectshop_folder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    List<Folder> findAllByUser(User user);
    List<Folder> findAllByUserAndNameIn(User user, List<String> names);

}