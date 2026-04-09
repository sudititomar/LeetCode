class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode fam = new ListNode(0);
    ListNode dam = fam;
    int carryy = 0;

    while (l1 != null || l2 != null || carryy > 0) {
      if (l1 != null) {
        carryy += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        carryy += l2.val;
        l2 = l2.next;
      }
      dam.next = new ListNode(carryy % 10);
      carryy /= 10;
      dam = dam.next;
    }

    return fam.next;
  }
}