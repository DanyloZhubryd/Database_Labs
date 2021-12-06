package ua.lviv.iot.mapper;

public interface AbstractMapper<Entity, DTO> {
    DTO map(Entity entity);
}
