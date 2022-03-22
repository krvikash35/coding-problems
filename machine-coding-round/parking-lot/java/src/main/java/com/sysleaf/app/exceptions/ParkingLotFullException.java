package com.sysleaf.app.exceptions;

import com.sysleaf.app.utils.MessageConstants;

public class ParkingLotFullException extends RuntimeException {

    @Override
    public String getMessage() {
        return MessageConstants.PARKING_LOT_FULL_MSG;
    }
}
