/* Navneeth Babra, 114716712 
	 * Fall 2018, Project #8 
	 * 
	 * pq.c 
	 * 
	 * Making a dynamically allocated priority queue, where the elements are 
	 * strings and the priority is assigned using non-negative integers. 
	 */ 
	#include "pq.h" 
	#include <string.h> 
	#include <stdio.h> 
	#include <stdlib.h> 
	 
	 
	 
	/* Initializes the priority queue used the pointer parameter passed in,  
	 * allocating memory for the priority queue data structure, but not for the  
	 * pointer which already exists. 
	 */ 
	void init(Priority_queue *const pq) 
	{ 
	 
	  if ( pq != NULL ) 
	    { 
	       
	      pq -> head = (Node *)calloc( 1, sizeof(Node) ); 
	      pq -> pq_size = 0; 
	       
	    } 
	 
	} 
	 
	/* Add new_element with priority into the priority queue, and return 1. 
	 * If there is an element with the same priority in the queue, return 0, and do 
	 * not add the new_element. new_element is copied into a dynamically allocated 
	 * array. 
	 */ 
	int enqueue(Priority_queue *const pq, const char new_element[], int priority) 
	{ 
	   
	  Node *temp, *curr, *equals; 
	 
	  if ( (pq == NULL) || (new_element == NULL) || (priority < 0) ) 
	    return 0; 
	   
	  temp = (Node *)malloc( sizeof(Node) ); 
	   
	  if (temp != NULL) 
	    { 
	      temp -> data = (char *)malloc( sizeof(new_element) * 
	                                     strlen(new_element) ); 
	      if (temp -> data != NULL) 
	        strcpy( temp -> data, new_element ); 
	      temp -> priority = priority; 
	 
	    } 
	 
	  if ( (pq -> head == NULL) || (priority > pq -> head -> priority) ) 
	    { 
	 
	      /* if head is null or if the argument's priority is greater, make the  
	       * new node the head */ 
	      temp -> next = pq -> head; 
	      pq -> head = temp; 
	      pq -> pq_size++; 
	       
	      return 1; 
	 
	    } 
	  else if (priority < pq -> head -> priority) 
	    { 
	       
	      curr = pq -> head; 
	      equals = pq -> head; 
	 
	      /* checking whether there is a node with the same priority already 
	       * in the list */ 
	      while ( equals -> next != NULL) 
	        { 
	 
	          if (equals -> next -> priority == priority) 
	            return 0; 
	          else 
	            equals = equals -> next; 
	 
	        } 
	      /* find the node to insert the temp node right after */ 
	      while ( (curr -> next != NULL) && 
	              ( (curr -> next -> priority) > priority) ) 
	        curr = curr -> next; 
	        
	      temp -> next = curr -> next; 
	      curr -> next = temp; 
	      pq -> pq_size++; 
	 
	      return 1; 
	       
	    } 
	   
	  return 0; 
	} 
	 
	/* Return 1 if there are no elements in the priority queue, return 0, if there  
	 * are. 
	 */ 
	int is_empty(const Priority_queue pq) 
	{ 
	 
	  if ( pq.pq_size == 0 ) 
	    return 1; 
	 
	  return 0; 
	 
	} 
	 
	/* Return the number of elements in the priority queue, where it will always be  
	 * 0 or more. 
	 */ 
	int size(const Priority_queue pq) 
	{ 
	 
	  return pq.pq_size; 
	 
	} 
	 
	/* Return a new dynamically allocated string, or deep copied string, of the  
	 * element in pq that has the highest priority, without removing it. If pq 
	 * is currently empty, return NULL. 
	 */ 
	char *peek(Priority_queue pq) 
	{ 
	  Node *temp; 
	  char *result; 
	   
	  if ( is_empty(pq) ) 
	    return NULL; 
	   
	  temp = malloc( sizeof(Node) ); 
	   
	  if (temp != NULL) 
	    temp = pq.head; 
	 
	  result = malloc( sizeof(char) * strlen( temp -> data ) ); 
	 
	  if (result != NULL) 
	    strcpy( result, temp -> data ); 
	 
	  return result; 
	   
	} 
	 
	/* Remove the element with the highest priority from the queue, and return a  
	 * char pointer to the removed string. If pq is empty, return NULL. 
	 */ 
	char *dequeue(Priority_queue *const pq) 
	{ 
	   
	  Node *temp; 
	 
	  if ( (pq == NULL) || (pq -> pq_size == 0) ) 
	      return NULL; 
	 
	  temp = pq -> head; 
	   
	  pq -> head = (pq -> head -> next); 
	  pq -> pq_size--; 
	 
	 
	  return temp -> data; 
	       
	} 
	 
	/* Remove all elements in the priority queue, but does not have to free up the  
	 * memory of the elements removed. 
	 */ 
	void clear(Priority_queue *const pq) 
	{ 
	   
	  if (pq != NULL) 
	    { 
	       
	      /* dequeue until size is 0 */ 
	      while ( pq -> pq_size != 0 ) 
	        dequeue(pq); 
	       
	    } 
	 
	} 
	 
	/* Return a deep copied dynamically allocated array of the pointers to  
	 * characters, in the order of decreasing priority. The last element in the  
	 * returned array should be a NULL value (n+1 elements). 
	 */ 
	char **get_all_elements(Priority_queue pq) 
	{ 
	   
	  char **arr, **result; 
	  int i = 0, num_elem = pq.pq_size + 1; 
	   
	  Node *temp = pq.head; 
	   
	  arr = malloc(  num_elem * sizeof( char* ) ); 
	 
	  /* returning the string array at the front, not end */ 
	  if ( arr != NULL ) 
	    result = arr; 
	 
	  if ( ( !size(pq) ) || ( temp == NULL ) ) 
	    { 
	       
	      arr[0] = NULL; 
	       
	    } 
	  else 
	    { 
	       
	      while( temp -> next  != NULL  ) 
	        { 
	           
	          arr[i] = malloc( strlen(temp -> data) + 1 ); 
	          if (arr[i] != NULL) 
	            { 
	               
	              strcpy( arr[i++], temp -> data ); 
	              temp = temp -> next; 
	               
	            } 
	 
	        } 
	 
	      arr[i+1] = NULL; 
	       
	    } 
	 
	  return result; 
	 
	} 
	 
	 
	 
	/* Remove all elements that are greater than or equal to low and less than or 
	 * equal to high. If no elements exist in that priority range, return 0,  
	 * otherwise return 1 after removing said elements. 
	 */ 
	int remove_elements_between(Priority_queue *const pq, int low, int high) 
	{ 
	   
	  Node *curr; 
	  int count = 0; 
	 
	  if (pq == NULL) 
	    return 0; 
	 
	  curr = pq -> head; 
	   
	  while (curr -> next != NULL) 
	    { 
	 
	      /* check if priority of current node is in the correct range */ 
	      if ( ( (curr -> priority > low) && (curr -> priority <= high) ) 
	           || ( (curr -> priority >= low) && (curr -> priority < high) ) ) 
	        { 
	           
	          *curr = *(curr -> next); 
	          pq -> pq_size--; 
	          count++; 
	           
	        } 
	      else 
	        { 
	           
	          curr = curr -> next; 
	           
	        } 
	         
	    } 
	 
	  /* if any number of nodes were removed return 1, if nothing changed, 0 */ 
	  if ( count ) 
	    return 1; 
	   
	  return 0; 
	   
	} 