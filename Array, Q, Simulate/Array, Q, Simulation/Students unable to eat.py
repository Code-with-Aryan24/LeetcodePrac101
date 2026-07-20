class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        # Count how many students want circular (0) and square (1)
        count0 = students.count(0)
        count1 = students.count(1)
        
        for sandwich in sandwiches:
            if sandwich == 0 and count0 > 0:
                count0 -= 1  # A student takes the circular sandwich
            elif sandwich == 1 and count1 > 0:
                count1 -= 1  # A student takes the square sandwich
            else:
                # Nobody wants the top sandwich, the line is stuck!
                break
                
        # The remaining students are those who couldn't eat
        return count0 + count1