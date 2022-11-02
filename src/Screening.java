import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        // 수신자인 Movie가 아니라 송신자인 Screening의 의도를 표현한다 => 캡슐화
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
