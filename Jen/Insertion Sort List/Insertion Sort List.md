# Insertion Sort List

> ### Leetcode / <a href = https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4485/> Medium. Insertion Sort List </a>

<br>

## 💡 approaches
>  - 삽입 정렬 탐색

> - 삽입 정렬은 탐색 시작 지점부터 다음 지점과 크기를 비교 후 swap하는 과정으로 이루어지만, 
> - 이 문제의 경우 ListNode는 클래스 변수로 val과 next만 있어 왼쪽 방향으로 swap이 불가능하다. 
> - 이를 위해 별도의 ListNode를 저장할 객체를 선언, 주어진 head의 각 노드에 대해 새로운 객체의 처음 -> 마지막까지 탐색하여 조건이 충족되면 객체에 ListNode를 삽입하고 원점으로 돌아가 head의 다음 Node의 값과 비교 연산을 수행한다. 

<br>

## 🔑 quiz solution

> - 정렬할 대상과 정렬을 끝낸 대상, 두 개로 나눈다. 
> - head는 정렬할 대상, cur는 정렬을 끝낸 대상, cur, node는 빈 노드이다. 
> - while문으로 head를 반복, cur에 정렬을 끝낸 연결 리스트를 추가, node는 계속 그 위치에 두고 루트를 가리킨다. 
> - 정렬을 끝낸 cur은 이미 정렬된 상태이므로, head와 비교해 더 작은 경우 cur.next를 이용해 다음으로 이동한다.
> - 정렬이 필요한 위치인 cur에 삽입될 위치를 찾았다면 cur 연결 리스트에 추가한다. 
> - 찾은 cur 위치 다음에 head가 들어가고 head.next에는 cur.next를 연결해 계속 이어지도록 한다.
> - 다음 head는 head.next로 이어받고 이 후 cur = node로 다시 원점으로 되돌아가며 비교한다.

> - cur, head의 위치를 생각할 때 cur = cur.next에 node가 따라가는 것이 아님에 주의한다. 

```py
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
```