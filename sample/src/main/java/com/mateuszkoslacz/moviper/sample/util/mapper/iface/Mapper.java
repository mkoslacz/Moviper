package com.mateuszkoslacz.moviper.sample.util.mapper.iface;

/**
 * Created by mateuszkoslacz on 13.08.2016.
 */
public interface Mapper<From, To> {
    To map(From from);
}