package bridge;

import camp.nextstep.edu.missionutils.Console;
import message.ErrorMessage;

import static message.ErrorMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                int bridgeSize = checkBridgeSize(Integer.parseInt(Console.readLine()));
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkBridgeSize(int bridgeSize) { // 문자로 들어왔을 경우에도 예외처리 해줘야한다.
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_ERROR.getMessage());
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String upOrDown = checkMoving(Console.readLine());
                return upOrDown;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String checkMoving(String upOrDown) { // 숫자일 경우도 예외지만, 숫자는 그냥 String으로 받아올 수 있으니까 괜찮지 않을까?
        if (upOrDown != "U" || upOrDown != "D") {
            throw new IllegalArgumentException(MOVING_ERROR.getMessage());
        }
        return upOrDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String retryOrNot = checkGameCommand(Console.readLine());
                return retryOrNot;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String checkGameCommand(String retryOrNot) {
        if (retryOrNot != "R" || retryOrNot != "Q") {
            throw new IllegalArgumentException(RETRY_INPUT_ERROR.getMessage());
        }
        return retryOrNot;
    }

}
