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
	private List<String> list = new ArrayList<String>();
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
			pagesCount = (textLines.size() / pageSize) - 1;
		} else {
			pagesCount = (textLines.size() / pageSize);
		}

		return pagesCount;
	}

	/**
	 * Print element from next page on screen.
	 */
	public List<String> next() {

		if(hasNext()) {
			currentPage = getCurrentPageNumber() + 1;
			int startPosition = getCurrentPageNumber() * pageSize;
			int endPosition = (getCurrentPageNumber() * pageSize) + pageSize;
			
			if(endPosition > textLines.size() ) {
				endPosition = textLines.size();
			}
			
			list = textLines.subList(startPosition, endPosition);
		} else {
			System.out.println(" >>> You are on the last page. Can not navigate to next!");
			System.out.println();
		}
		return list;
	}

	/**
	 * Print elements from previous page on screen.
	 */
	public List<String> previous() {

		if(hasPrevious()) {
			currentPage = getCurrentPageNumber() - 1;
			int startPosition = getCurrentPageNumber() * pageSize;
			int endPosition = (getCurrentPageNumber() * pageSize) + pageSize;
			
			list = textLines.subList(startPosition, endPosition);
		} else {
			System.out.println(" >>> You are on the first page. Can not navigate to previous!");
			System.out.println();
		}
		return list;
	}

	/**
	 * Check if next page is available.
	 * 
	 * @return true if there's next page or false if there's no next page
	 */
	public boolean hasNext() {

		if (getCurrentPageNumber()  < pagesCount()) {
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
	public List<String> firstPage() {
		currentPage = 0;
		return list = textLines.subList(0, pageSize);
	}

	/**
	 * Get all elements from last page and print it on the screen.
	 */
	public List<String> lastPage() {
		int startPosition = pagesCount() * pageSize;
		currentPage = pagesCount();
		return list = textLines.subList(startPosition, textLines.size());
	}

	/**
	 * Get number of the current page shown on screen.
	 * @return number of the page
	 */
	public int getCurrentPageNumber() {
		return currentPage;
	}
}
