package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

@Named("MemberMappers")
@Mapper(componentModel ="spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OrderMapper.class})
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);
/*
    @Named("toDto")
    @Mappings({})
    MemberDto memberToDto(Member member);

    @Named("toDtoWithoutOrders")
    @Mappings({
            @Mapping(target = "orderDtoList",expression = "java(null)")
    })
    MemberDto memberToDtoWithoutOrders(Member member);*/

    @Mappings({
            @Mapping( source = "orderList",target = "orderDtoList", qualifiedByName = {"OrderMapper","orderToDto"})
    })
    MemberDto memberToDto(Member member);


    Member dtoToMember(MemberDto memberDto);
}
