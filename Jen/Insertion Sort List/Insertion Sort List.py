# Definition for singly-linked list.

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = node = ListNode(0)
        
        while head:
            while cur.next and cur.next.val < head.val:
                # cur.nexrt 값이 head보다 작아서 오른쪽에 넣을 필요가 없을 경우, cur 전진
                cur = cur.next
            
            # cur.next의 값이 head와 같거나 커서 오른쪽에 넣는다.
            cur.next, head.next, head = head, cur.next, head.next
            
            if head and cur.val > head.val:
                # head가 존재하고 cur 값이 head보다 커서 왼쪽에 넣어야하는 경우, cur를 원점으로 돌아간다. 
                cur = node
                
        return node.next