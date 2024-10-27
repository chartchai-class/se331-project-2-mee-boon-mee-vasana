package se331.rest.utill;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.rest.DTO.*;
import se331.rest.entity.Comment;
import se331.rest.entity.Country;
import se331.rest.entity.Medal;
import se331.rest.entity.SportDetail;
import se331.rest.security.user.User;
import se331.rest.security.user.UserDTO;

import java.util.List;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    //country DTO
    CountryDTO getCountryDTO(Country country);
    List<CountryDTO> getCountryDTO(List<Country> countries);

    //Medal DTO
    MedalDTO getMedalDTO(Medal medal);
    List<MedalDTO> getMedalDTO(List<Medal> medals);

    //Sport DTO
    SportDetailDTO getSportDetailDTO(SportDetail sportDetail);
    List<SportDetailDTO> getSportDetailDTO(List<SportDetail> sportDetails);

    //Comment DTO
    CommentDTO getCommentDTO(Comment comment);

    @Mapping(target = "roles", expression = "java(user.getRoles().stream().map(Enum::name).collect(java.util.stream.Collectors.toList()))")
    UserDTO getUserDTO(User user);

//    @Mapping(target = "roles", source = "user.roles")
//    CommentAuthDTO getCommentAuthDTO(Comment comment);


}
