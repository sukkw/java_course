package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Get list with text lines. Separate text in pages and print 
 * different page depending on user choice.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class PageBean {

	// class private members
	private int pageSize;
	private List<String> textLines = new ArrayList<String>();
	private int currentPage;

	/**
	 * Constructor.
	 * 
	 * @param pageSize - number of elements to be shown
	 * @param textLines - list with text lines
	 */
	public PageBean(int pageSize, List<String> textLines) {
		this.pageSize = pageSize;
		this.textLines = textLines;
	}

	/**
	 * Calculate number of all available pages.
	 * @return - number of all pages
	 */
	public int pagesCount() {

		int pagesCount;
		if (textLines.size() % pageSize == 0) {
			pagesCount = textLines.size() / pageSize;
		} else {
			pagesCount = (textLines.size() / pageSize) + 1;
		}

		return pagesCount;
	}

	/**
	 * Print element from next page on screen.
	 */
	public void next() {
		
		currentPage = getCurrentPageNumber() + 1;
		int startPosition = getCurrentPageNumber() * pageSize;
		int endPosition = (getCurrentPageNumber() * pageSize) + pageSize;
		
		if(endPosition > textLines.size() ) {
			endPosition = textLines.size();
			currentPage = getCurrentPageNumber() - 1;
		}
		for(int i=startPosition; i<endPosition; i++) {
			System.out.println(textLines.get(i));
		}
	}

	/**
	 * Print elements from previous page on screen.
	 */
	public void previous() {

		if(hasPrevious()) {
			currentPage = getCurrentPageNumber() - 1;
			int startPosition = getCurrentPageNumber() * pageSize;
			int endPosition = (getCurrentPageNumber() * pageSize) + pageSize;
			
			for(int i=startPosition; i<endPosition; i++) {
				System.out.println(textLines.get(i));
			}
		} else {
			System.out.println("Can not navigate to previous page!");
		}
	}

	/**
	 * Check if next page is available.
	 * 
	 * @return true if there's next page or false if there's no next page
	 */
	public boolean hasNext() {

		if (getCurrentPageNumber() < pagesCount()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if previous page is available.
	 * 
	 * @return true if there's previous page or false if there's no previous page
	 */
	public boolean hasPrevious() {
		if (getCurrentPageNumber() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get all elements from first page and print it on the screen.
	 */
	public void firstPage() {
		currentPage = 0;
		for(int i=0; i<pageSize; i++) {
			System.out.println(textLines.get(i));
		}
	}

	/**
	 * Get all elements from last page and print it on the screen.
	 */
	public void lastPage() {
		int startPosition = (pagesCount()-1) * pageSize;
		for(int i=startPosition; i<textLines.size(); i++) {
			System.out.println(textLines.get(i));
		}
		currentPage = pagesCount()-1;
	}

	/**
	 * Get number of the current page shown on screen.
	 * @return number of the page
	 */
	public int getCurrentPageNumber() {
		return currentPage;
	}

}
