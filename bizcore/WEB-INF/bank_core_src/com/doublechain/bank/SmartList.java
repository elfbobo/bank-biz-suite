package com.doublechain.bank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.function.Consumer;

/*
 * 
 * 
SmartList??List?????BaseEntity?

?????????????????????????LinkedList???????????????List????????????

??BaseEntity???????actionList?message??

actionList - ?????????????????
message - ????????????
count??????????
toRemoveList??????????
facetList????????
 * 
 * */
public class SmartList<E  extends BaseEntity> extends BaseEntity implements List<E> {

	public void forEach(Consumer<? super E> action) {
		ensureSmartList();
		smartList.forEach(action);
	}
	
	public StatsInfo getStatsInfo() {
		return statsInfo;
	}

	public void setStatsInfo(StatsInfo statsInfo) {
		this.statsInfo = statsInfo;
	}
	private StatsInfo statsInfo;
	
	public SmartListMetaInfo getMetaInfo() {
		
		return metaInfo;
	}
	
	public void setMetaInfo(SmartListMetaInfo metaInfo) {
		this.metaInfo = metaInfo;
	}
	private SmartListMetaInfo metaInfo;
	
	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	private boolean accessible = true;//???????????
	

	private String listInternalName;
	public String getListInternalName() {
		return listInternalName;
	}
	
	public void setListInternalName(String listInternalName) {
		this.listInternalName = listInternalName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<E> smartList;
	
	private long counter = 0;
	private static final long SWITCH_COUNT=100000;
	protected void tryToKeepArrayListList(){
		--counter;
	}
	
	protected void tryToSwithToLinkedList(){
		
		++counter;
		
		if(smartList instanceof LinkedList){
			return;
		}
		//?????LinkedList?????LinkedList?
		if(counter > SWITCH_COUNT){
			List<E> tempList = new LinkedList<E>();
			tempList.addAll(smartList);
			
			smartList = tempList;
		}
		
	}
	public E first(){
		
		ensureSmartList();
		
		if(smartList.size()==0){
			return null;
		}
		
		return smartList.get(0);
		
	}
	public E last(){
		
		ensureSmartList();
		int size = smartList.size();
		if(size==0){
			return null;
		}
		
		return smartList.get(size-1);
	}
	protected void ensureSmartList(){
		if(smartList!=null){
			return;
		}
		smartList = new ArrayList<E>();
	}
	public SmartList(){
		super();
		
	}
	public int size() {
		ensureSmartList();
		return smartList.size();
	}
	public Stream<E> stream() {
		ensureSmartList();
		return smartList.stream();
	}
	public boolean isEmpty() {
		ensureSmartList();
		return smartList.isEmpty();
	}

	public boolean contains(Object o) {
		ensureSmartList();
		return smartList.contains(o);
	}

	public Iterator<E> iterator() {
		ensureSmartList();
		return smartList.iterator();
	}

	public Object[] toArray() {
		ensureSmartList();
		return smartList.toArray();
	}

	public <T> T[] toArray(T[] a) {
		ensureSmartList();
		tryToKeepArrayListList();// ?????ArrayList??????????LinkedList???
		return smartList.toArray(a);
	}

	public boolean add(E e) {
		ensureSmartList();
		return smartList.add(e);
	}

	public boolean remove(Object o) {
		ensureSmartList();		
		return smartList.remove(o);
	}
	
	
	public boolean planToRemove(E o) {
		ensureSmartList();
		o.clearFromAll();
		this.addToRemoveList(o);
		return smartList.remove(o);
	}
	public boolean containsAll(Collection<?> c) {
		ensureSmartList();
		return smartList.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		ensureSmartList();
		return smartList.addAll(c);
	}
	private int totalCount = 0;
	public int getTotalCount(){
		
		if(totalCount<size()){
			return size();
		}
		return totalCount;
		
	}
	
	
	
	public void setTotalCount(int newTotalCount){
		if(newTotalCount <= 0){
			return;
		}
		this.totalCount = newTotalCount;
	}
	
	protected List<BaseEntity> pagesOf(){
		
		List<BaseEntity> pages = new Pagination(this.getTotalCount()
				, this.getRowsPerPage()
				).render(this.getCurrentPageNumber());
		return pages;

	}
	public List<BaseEntity> getPages(){
		
		
		List<BaseEntity> pages =  pagesOf();
		
		if(pages.size()<2){
			return new ArrayList<BaseEntity>();
		}
		return pages;
	}
	
	private int currentPageNumber = 1;
	public void setCurrentPageNumber(int number){
		if(number<1){
			return;
		}
		currentPageNumber = number;
	}
	public int getCurrentPageNumber() {
		// TODO Auto-generated method stub
		return currentPageNumber;
	}
	private int rowsPerPage = 20;
	
	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		if(rowsPerPage<1){
			return;
		}
		this.rowsPerPage = rowsPerPage;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		if(c == null){
			return false;
		}
		ensureSmartList();
		if(index < this.size()){
			//??index??????????????????????????????Linkedlist?
			this.tryToSwithToLinkedList();
		}
		return smartList.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		ensureSmartList();
		return smartList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		ensureSmartList();
		return smartList.retainAll(c);
	}

	public void clear() {
		ensureSmartList();
		smartList.clear();
	}

	public boolean equals(Object o) {
		ensureSmartList();
		return smartList.equals(o);
	}

	public int hashCode() {
		ensureSmartList();
		return smartList.hashCode();
	}

	public E get(int index) {
		ensureSmartList();
		tryToKeepArrayListList();// ?????ArrayList??????????LinkedList???
		return smartList.get(index);
	}

	public E set(int index, E element) {
		ensureSmartList();
		if(index < this.size()){
			//??index??????????????????????????????Linkedlist?
			this.tryToSwithToLinkedList();
		}
		return smartList.set(index, element);
	}

	public void add(int index, E element) {
		ensureSmartList();
		if(index < this.size()){
			//??index??????????????????????????????Linkedlist?
			this.tryToSwithToLinkedList();
		}
		smartList.add(index, element);
	}

	public E remove(int index) {
		
		ensureSmartList();
		if(index < this.size()){
			//??index??????????????????????????????Linkedlist?
			this.tryToSwithToLinkedList();
		}
		return smartList.remove(index);
	}

	public int indexOf(Object o) {
		ensureSmartList();
		return smartList.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		ensureSmartList();
		return smartList.lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		ensureSmartList();
		return smartList.listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		ensureSmartList();
		tryToKeepArrayListList();// ?????ArrayList??????????LinkedList???
		return smartList.listIterator(index);
	}

	public List<E> subList(int fromIndex, int toIndex) {
		ensureSmartList();
		tryToKeepArrayListList();// ?????ArrayList??????????LinkedList???
		return smartList.subList(fromIndex, toIndex);
	}
	public SmartList<E> subListOf(int fromIndex, int toIndex) {
		ensureSmartList();
		tryToKeepArrayListList();// ?????ArrayList??????????LinkedList???
		
		SmartList<E> newSmartList = new SmartList<E>();
		newSmartList.addAll(smartList.subList(fromIndex, toIndex));
		return newSmartList;
	}
	
	private List<E> toRemoveList;
	private QueryCriteria queryCriteria;
	public void addToRemoveList(E e) {
		ensureToRemoveList();
		toRemoveList.add(e);
		
	}
	protected void removeToRemoveList(E e) {
		if(toRemoveList ==null){
			return;
		}
		
		toRemoveList.remove(e);
		
	}
	private void ensureToRemoveList() {
		if(toRemoveList !=null){
			return;
		}
		toRemoveList = new ArrayList<E>();
		
	}
	public  boolean planToRemoveAll() {
		
		
		ensureSmartList();
		
		//T[] elements = this.get
		for(E o:smartList){
			this.addToRemoveList(o);			
		}
		this.clear();
		
		
		
		return true;
	}
	public SmartList<E> getToRemoveList() {
		if(toRemoveList == null){
			return null;
		}
		SmartList<E> newSmartList = new SmartList<E>();
		newSmartList.addAll(toRemoveList);
		return newSmartList;
	}

	public void setQueryCriteria(QueryCriteria qc) {
		// TODO Auto-generated method stub
		this.queryCriteria = qc;
	}
	
	public void addAllToRemoveList(SmartList<E> externalToRemoveList) {
		
		if(toRemoveList == null){
			toRemoveList = new SmartList<E>();;
		}
		toRemoveList.addAll(externalToRemoveList);
	}
	public Map<String, E> mapWithId() {
		Map<String, E> map = new HashMap<String, E>();
		for(E e: smartList){
			
			if( e == null){
				continue;
			}
			if(e.getId()==null){
				continue;
			}
			map.put(e.getId(), e);
			
		}
		return map;
	}
	
	public String[] idArray() {
		List <String> list = new ArrayList<String>();
		
		for(E e: smartList){
			
			if( e == null){
				continue;
			}
			if(e.getId()==null){
				continue;
			}
			list.add(e.getId());
			
			
		}
		return list.toArray(new String[]{});
	}
	
}















