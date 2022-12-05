package dao;

public interface Parser<T> {
	T parse(String[] items);
}
