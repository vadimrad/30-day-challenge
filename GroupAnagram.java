class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Calc hashes 
        // 2. Check each word by hash and detect collisions
        Map<Integer, List<List<String>>> map = new HashMap<>();
        
        for (String s : strs) {
            int hash = calcHash(s);
            if (map.get(hash) == null) {
                List<List<String>> list = new ArrayList<>();
                list.add(new ArrayList<>());
                list.get(0).add(s);
                map.put(hash, list);
                continue;
            }
            
            for (int i = 0; i < map.get(hash).size(); ++i) {
                List<String> list = map.get(hash).get(i);
                //if (list.size() == 0) {
                //    list.add(s);
                //} else {
                    boolean isEqual = compareStrings(s, list.get(0));
                    if (isEqual) {
                        list.add(s);
                        break;
                    } else {
                        if (map.get(hash).size() - 1 == i) {
                            List<String> newList = new ArrayList<>();
                            newList.add(s);
                            map.get(hash).add(newList);
                            break;
                        }
                    }
                //}
            }   
        }
        List<List<String>> result = new ArrayList<>();
        for (List<List<String>> lists : map.values()) {
            for (List<String> list : lists) {
                result.add(list);
            }
        }
        return result;
    }
    
    private boolean compareStrings(String s1, String s2) {
        int[] mask = new int[26];
        for (char c : s1.toCharArray()) {
            mask[c - 'a']++;
        }
        
        for (char c : s2.toCharArray()) {
            mask[c - 'a']--;
        }
        
        for (int i : mask) {
            if (i != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private int calcHash(String s) {
        int hash = 0;
        for (char c : s.toCharArray()) {
            hash += (c - 'a' + 1) * 31;
        }
        
        return hash;
    }
}
