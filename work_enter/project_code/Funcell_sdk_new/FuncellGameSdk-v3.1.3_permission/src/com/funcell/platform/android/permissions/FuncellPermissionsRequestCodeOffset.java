package com.funcell.platform.android.permissions;


public enum FuncellPermissionsRequestCodeOffset {
	/**
	 * CALENDAR ������  1-2
	 * CAMERA ���������  3
	 * CONTACTS ��ϵ����  4-6
	 * LOCATION ��λ�� 7-8
	 * MICROPHONE ��˷��� 9
	 * PHONE �� 10-15
	 * SENSORS ��������  16
	 * SMS �� 17-21
	 * STORAGE �洢�� 22-23
	 */
	READ_CALENDAR(1),
	WRITE_CALENDAR(2),
	CAMERA(3),
	READ_CONTACTS(4),
	WRITE_CONTACTS(5),
	GET_ACCOUNTS(6),
	ACCESS_FINE_LOCATION(7),
	ACCESS_COARSE_LOCATION(8),
	RECORD_AUDIO(9),
	READ_PHONE_STATE(10),
	CALL_PHONE(11),
	READ_CALL_LOG(12),
	WRITE_CALL_LOG(13),
	USE_SIP(14),
	PROCESS_OUTGOING_CALLS(15),
	BODY_SENSORS(16),
	SEND_SMS(17),
	RECEIVE_SMS(18),
	READ_SMS(19),
	RECEIVE_WAP_PUSH(20),
	RECEIVE_MMS(21),
	READ_EXTERNAL_STORAGE(22),
	WRITE_EXTERNAL_STORAGE(23),
    ;
	
	private int offset;
	FuncellPermissionsRequestCodeOffset(int offset) {
        this.offset = offset;
    }
	
	public int toRequestCode() {
        return offset;
    }
}