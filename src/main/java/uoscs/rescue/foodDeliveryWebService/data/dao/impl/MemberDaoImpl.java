package uoscs.rescue.foodDeliveryWebService.data.dao.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.stereotype.Repository;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.mapper.MemberMapper;
import uoscs.rescue.foodDeliveryWebService.data.repository.MemberRepository;
import uoscs.rescue.foodDeliveryWebService.exception.NoSuchMemberException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository //transactional 적용됨
@AllArgsConstructor
public class MemberDaoImpl implements MemberDao {
    @Autowired
    final private MemberRepository repository;
    @Autowired
    final private MemberMapper memberMapper;

    //@Autowired final private EntityManager entityManager;
    //
    //private final
    @Override
    public MemberDto save(MemberDto memberDto) {
        Member member = memberMapper.dtoToMember(memberDto);
        Member savedMember = repository.save(member);
        log.info("member saved {}", savedMember);

        return memberMapper.memberToDto(savedMember);
    }

    private Member getMemberEntityById(String id){
        Optional<Member> optionalMember = repository.findById(id);

        if(optionalMember.isEmpty())
            throw new NoSuchMemberException("No such member id: "+ id);
        return optionalMember.get();
    }


    @Override
    public MemberDto findById(String id) {
        Member member = getMemberEntityById(id);

        return memberMapper.memberToDto(member);
    }

    @Override
    public Member findMemberEntityById(String id) {
        return getMemberEntityById(id);
    }

    @Override
    public List<MemberDto> getAllMemberList() {
        List<MemberDto> memberDtoList = memberMapper.memberListToDtoList(repository.findAll());
        return memberDtoList;
    }

    @Override
    public void updateById(String id, MemberDto updateDto) {
        Member member = getMemberEntityById(id);
        member.setName(updateDto.getName());
        member.setGrade(updateDto.getGrade());
        member.setAuthority(updateDto.getAuthority());

        log.info("update member id: {}, data: {}", id, updateDto);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        log.info("delete member id = "+ id);
    }
}
