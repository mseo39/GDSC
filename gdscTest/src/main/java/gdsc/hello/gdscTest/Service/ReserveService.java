package gdsc.hello.gdscTest.Service;

import gdsc.hello.gdscTest.domain.Reserve;
import gdsc.hello.gdscTest.dto.CreateReserveDto;
import gdsc.hello.gdscTest.dto.UpdateReserveDto;
import gdsc.hello.gdscTest.respository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveRepository reserveRepository;

    //경기 생성
    @Transactional
    public Long createReserve(CreateReserveDto createReserveDto){

        Reserve reserve = Reserve.createReserve(createReserveDto.getTitle(),
                createReserveDto.getExplanation(), createReserveDto.getRecruitmentNum(),
                createReserveDto.getSport(), createReserveDto.getStartT(),
                createReserveDto.getEndT());
        reserveRepository.save(reserve);
        return reserve.getId();
    }

    // 모든 경기 리스트 조회
    @Transactional
    public List<Reserve> allMatch(){
        List<Reserve> reserve = reserveRepository.findAll();
        return reserve;
    }

    // 업데이트
    @Transactional
    public Long updateReserve(Long reserveId, UpdateReserveDto reserveDto){

        Reserve reserve = reserveRepository.findOne(reserveId);

        reserve.setEndT(reserveDto.getEndT());
        reserve.setStartT(reserveDto.getStartT());

        reserve.setSport(reserveDto.getSport());

        reserve.setTitle(reserveDto.getTitle());
        reserve.setExplanation(reserveDto.getExplanation());
        reserve.setRecruitmentNum(reserveDto.getRecruitmentNum());

        return reserve.getId();
    }

    //경기 삭제
    @Transactional
    public void deleteReserve(Long reserveId){
        //경기 엔티티 조회
        Reserve findReserve = reserveRepository.findOne(reserveId);

        //삭제
        reserveRepository.delete(findReserve);
    }
}