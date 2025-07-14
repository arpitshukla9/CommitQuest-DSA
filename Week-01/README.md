# Week 01 — DSA Problems

Three classic interview problems with clean, readable solutions.

---

## Problems

| # | Problem | Difficulty | Key Concept |
|---|---------|------------|-------------|
| 1 | Min in Rotated Sorted Array | Medium | Binary Search |
| 2 | Subarray Sum Equals K | Medium | Prefix Sum + HashMap |
| 3 | Paint Houses | Medium | DP with Two Mins |

---

## Problem Details

### 1. Min in Rotated Sorted Array
**What:** Find minimum in rotated sorted array  
**How:** Binary search - compare mid with right  
**Time:** O(log n), **Space:** O(1)

### 2. Subarray Sum Equals K  
**What:** Count subarrays with sum = k  
**How:** Track prefix sums in HashMap  
**Time:** O(n), **Space:** O(n)

### 3. Paint Houses
**What:** Paint n houses with k colors, no adjacent same color  
**How:** Track two minimum costs from previous house  
**Time:** O(n × k), **Space:** O(1)

---

## Files

```
Week-01/
├── MinInRotatedSortedArray.java
├── SubarraySumEqualsK.java  
├── RubySecondHouse.java
└── README.md
```

---

## Code Style

- Single class per problem
- Static methods for simplicity
- Clear variable names
- Minimal but helpful comments
- Interview-ready format

---

> Keep coding, keep learning! 🚀  