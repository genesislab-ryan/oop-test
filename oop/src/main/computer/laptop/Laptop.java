package main.computer.laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Laptop {

    String vendor = "";
    String Model = "";
    int cpu = 0;
    int ram = 0;
    int disk = 0;
    List<Integer> applicationIdList = new ArrayList<>();
    int runningApplication = 0;
    boolean systemStart = false;
    int weight = 1;

    /*
    * - 디스플레이 : 랩탑 객체에 내장되어 휴대성을 위해 11인치, 13인치, 15인치 디스플레이 속성을 선택할 수 있습니다.
- 제조사 : 랩탑 객체를 상속받은 노트북 인스턴스가 생성될 때 기입되는 생산한 제조사 속성입니다.
- 모델 : 랩탑 객체를 상속받은 노트북 인스턴스에서 기입되는 모델 속성입니다.
- CPU : 랩탑 객체에서 애플리케이션이 연산 등 목적으로 사용하는 처리 장치 속성으로, 애플리케이션이 실행하고 종료될 때, 그 수치 만큼 CPU의 남은 용량에서 차감하거나 사용량을 반환합니다.
- 메모리 : 랩탑 객체의 애플리e케이션이 실행될 때 현재 남아 있는 메모리 용량에서 실행 중인 애플리케이션의 메모리 비율 만큼 차감하고, 애플리케이션 종료시, 사용 중인 메모리 용량을 다시 반환합니다.
- Disk : 랩탑 객체의 애플리케이션이 설치될 수 있는 최대 저장 용량으로 애플리케이션 삭제 시, 차지하고 있는 저장 용량만큼 반환됩니다.
- 애플리케이션 목록 : 랩탑 객체에 설치되어 있는 애플리케이션들의 전체 내역을 확인할 수 있는 속성입니다.
- 실행 중인 애플리케이션 : 현재 랩탑 객체에서 실행 중인 애플리케이션으로, 실행하고 있는 애플리케이션은 최대 1개로 제한됩니다.
- 시스템 시작 여부 : 랩탑 객체의 실행 여부를 확인하는 속성으로, 해당 속성이 true로 되어 있지 않으면 모든 애플리케이션은 실행할 수 없습니다.
- 무게 : 랩탑 객체의 무게 값으로 휴대성을 위해 최대 3kg까지 설정할 수 있습니다.
    * */
}
