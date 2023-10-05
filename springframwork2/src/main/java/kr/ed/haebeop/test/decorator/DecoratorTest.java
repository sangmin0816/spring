package kr.ed.haebeop.test.decorator;
public class DecoratorTest {
    public static void main(String[] args) {
        Display road = new RoadDisplay();
        road.draw(); // 기본 도로 표시

        Display roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw(); // 기본 도로 표시 + 차선 표시

        Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
        roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시

        Display roadWithLaneAndTraffic =
                new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
        roadWithLaneAndTraffic.draw(); // 기본 도로 표시 + 차선 표시 + 교통량 표시
    }
}
/*
데코레이터(Decorator) 패턴 : 장식자 패턴
- 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우 각 추가 기능을 Decorator 클래스로 정의한 후 필요한 Decorator 객체를 조합함으로써 추가 기능의 조합을 설계
- 주어진 상황 및 용도에 따라 어떤 객체에 책임을 덧붙이는 패턴
- 기능 확장이 필요할 때 서브클래스 대신 사용할 수 있는 유연한 대안이 될 수 있음
- 앞으로의 변경이 얼마나 될지 모르는 상황에서 상속을 사용한 프로그래밍은 변경에 유연하지 못함
 */