package me.dio.sdw24.ports;

import me.dio.sdw24.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {

    List<Champions> findAll();

    Optional<Champions> findOne(Long id);
}
