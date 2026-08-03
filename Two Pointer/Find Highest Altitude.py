class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        current_altitude = 0
        max_altitude = 0  # We start at 0, so 0 is our initial max
        
        for g in gain:
            current_altitude += g  # Add the gain to get the new altitude
            max_altitude = max(max_altitude, current_altitude)  # Update max if needed
            
        return max_altitude