package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.MemberVO;
import com.it.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public MemberVO read(MemberVO member) {
		return mapper.read(member);
	}
	
	@Override
	public boolean auth(MemberVO member) {
		MemberVO tmp = new MemberVO();	// 임시변수(비어있는 객체)
		tmp = mapper.read(member);	// 아이디를 이용해서 모든 필드정보를 획득, 아이디가 틀리면 null 반환
		if (tmp != null) {	// 아이디가 맞는 경우 tmp에 사용자 정보 반환
			if (member.getM_passwd().equals(tmp.getM_passwd())) {	// 암호 동일할 경우
				log.info(tmp);
				log.info("인증 성공");
				return true;
			} else {	// 아이디는 일치하나 암호가 일치하지 않는 경우
				log.info(tmp);
				log.info(member);
				log.info("아이디는 동일하나 암호가 틀림");
				return false;
			}
		} else {	// 아이디가 존재하지 않는 경우
			log.info(member);
			log.info("아이디가 존재하지 않습니다.");
			return false;
		}

	}
	
	@Override
	public void insert(MemberVO member) {
		mapper.insert(member);
	}
	
	@Override
	public List<MemberVO> getList() {
		return mapper.getList();
	}

	@Override
	public void update(MemberVO member) {
		mapper.update(member);
	}
	
	@Override
	public void delete(MemberVO member) {
		mapper.delete(member);
	}

}
