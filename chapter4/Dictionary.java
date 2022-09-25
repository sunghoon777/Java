package chapter4;

public class Dictionary extends PairMap{
	
	private int length;
	private int capacity;

	public Dictionary(int capacity) {
		this.capacity = capacity;
		KeyArray = new String[capacity];
		valueArray = new String[capacity];
		length = 0;
	}
	
	@Override
	String get(String key) {
		// TODO Auto-generated method stub
		for(int i = 0 ;i < capacity; i++) {
		   if(KeyArray[i] != null) {
			   if(KeyArray[i].equals(key)) {
					return valueArray[i];
				}
		   }
		}
		return null;
	}

	@Override
	void put(String key, String value) {
		// TODO Auto-generated method stub
		boolean keyEx = false;
		int index = -1;
		for(int i =0 ; i < capacity; i++) {
			if(key.equals(KeyArray[i])) {
				index = i;
				keyEx = true;
				break;
			}
		}
		if(keyEx == true) {
			valueArray[index] = value;
		}
		else if(keyEx == false) {
			if(KeyArray.length == length) {
				capacity += 10;
				String tempKey[] = new String[capacity];
				String tempValue[] = new String[capacity];
				for(int i = 0 ;i < length; i++) {
					tempKey[i] = KeyArray[i];
					tempValue[i] = valueArray[i];
				}
				KeyArray = tempKey;
				valueArray = tempValue;
			}
			for(int i = 0 ;i < capacity; i++) {
				
				if(KeyArray[i] == null) {
					KeyArray[i] = key;
					valueArray[i] = value;
					System.out.println(valueArray[i]);
					length += 1;
					break;
				}
			}
		}
	}

	@Override
	String delete(String key) {
		// TODO Auto-generated method stub
		for(int i = 0 ;i < capacity; i++) {
			if(KeyArray[i].equals(key)) {
				String value = valueArray[i];
				KeyArray[i] = null;
				valueArray[i] = null;
				length -= 1;
				return value;
			}
		}
		return null;
	}

	@Override
	int length() {
		// TODO Auto-generated method stub
		return length;
	}

}
