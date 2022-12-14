package uoscs.rescue.foodDeliveryWebService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchMemberException;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberDao memberDao;

    @Override
    public MemberDto save(MemberDto memberDto) {
        return memberDao.save(memberDto);
    }

    @Override
    public MemberDto saveWithCheckId(MemberDto memberDto) {
        try{
            memberDao.findById(memberDto.getId());
        }catch (NoSuchMemberException ex){  //매칭되는 아이디가 없는 경우
            setGeneralValue(memberDto);
            return memberDao.save(memberDto);
        }

        return null;
    }

    private void setGeneralValue(MemberDto memberDto){
        memberDto.setAuthority(Authority.GENERAL);  //기본 값으로 세팅
        memberDto.setGrade(Grade.GENERAL);
    }

    @Override
    public boolean checkIdAndPassword(String id, String password) {
        MemberDto memberDto;

        try{
            memberDto = memberDao.findById(id);
        }catch (NoSuchMemberException ex){  //매칭되는 아이디가 없는 경우
            return false;
        }

        if(!memberDto.getPassword().equals(password))   //비번이 맞지 않는 경우
            return false;

        return true;
    }

    @Override
    public MemberDto findById(String id) {
       return memberDao.findById(id);
    }

    @Override
    public List<MemberDto> getAllMemberDtoList() {return memberDao.getAllMemberList();}

    //기본적인 정보만 변경 가능
    @Override
    public void updateMemberByGeneralAuth(String memberId, MemberDto updateDataDto){
        updateDataDto.setGrade(null);
        updateDataDto.setAuthority(null);
        memberDao.updateById(memberId , updateDataDto);
    }

    //관리자는 유저의 모든 정보 변경 가능
    @Override
    public void updateMemberByAdminAuth(String memberId, MemberDto updateDataDto){
        memberDao.updateById(memberId , updateDataDto);
    }

}
