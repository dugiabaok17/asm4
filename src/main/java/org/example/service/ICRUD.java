package org.example.service;

import java.util.List;

public interface ICRUD<T> {
	String save();
	List<T> findAll();
	String update();
	String delete();
}
