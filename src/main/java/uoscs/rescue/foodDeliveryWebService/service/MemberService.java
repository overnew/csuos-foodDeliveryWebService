package uoscs.rescue.foodDeliveryWebService.service;

import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

import java.util.List;

public interface MemberService {
    MemberDto save(MemberDto memberDto);
    MemberDto saveWithCheckId(MemberDto memberDto);

    boolean checkIdAndPassword(String id, String password);

    MemberDto findById(String id);
    List<MemberDto> getAllMemberDtoList();

    void updateMemberByGeneralAuth(String memberId, MemberDto updateDataDto);
    void updateMemberByAdminAuth(String memberId, MemberDto updateDataDto);
}
