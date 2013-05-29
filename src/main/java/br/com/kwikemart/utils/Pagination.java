/**
 * 
 */
package br.com.kwikemart.utils;

/**
 * @author Denis Santos
 *
 */
public abstract class Pagination {

	/**
	 * Examples: 
	 * - If page 1, to hibernate is register 0
	 * - If page 2 and the quantity per page is 4, to hibernate is register 4
	 * 
	 * @param page
	 * @param quantityPerPage
	 * @return
	 */
	public static int getPage(int page, int quantityPerPage) {
		return ((page - 1) * quantityPerPage);
	}
}
