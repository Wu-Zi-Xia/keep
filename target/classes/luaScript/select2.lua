local tableName=tostring(KEYS[1])
--local selectValue1=ARGV[2]
--local selectCondition2=ARGV[3]
--local selectValue2=ARGV[4]
local dbsize=redis.call("dbsize")
local myResultKeys=redis.call("scan",0,"match",tableName,"count",dbsize)
local keys= myResultKeys[2]
local result={}
local id=0
--按照指定字符分割字符串
local function Split(szFullString, szSeparator)
  local nFindStartIndex = 1
  local nSplitIndex = 1
  local nSplitArray = {}
  while true do
    local nFindLastIndex = string.find(szFullString, szSeparator, nFindStartIndex)
     if not nFindLastIndex then
      nSplitArray[nSplitIndex] = string.sub(szFullString, nFindStartIndex, string.len(szFullString))
     break
    end
   nSplitArray[nSplitIndex] = string.sub(szFullString, nFindStartIndex, nFindLastIndex - 1)
    nFindStartIndex = nFindLastIndex + string.len(szSeparator)
    nSplitIndex = nSplitIndex + 1
end
return nSplitArray
end
--计数函数（计算表的长度）
local function count(song)
local count = 0
for k,v in pairs(song) do
    count = count + 1
end
return count
end


--排序
local function sort(array)
local isChange=false
local size=#array
for i=1,size-1,1 do
isChange=false
	for j=1,size-1,1 do
		if array[j]>array[j+1] then
			array[j],array[j+1]=array[j+1],array[j]
			isChange=true
		end
	end
	if not isChange then
    		break
    	end
end
end


--别人写的排序
local function bubbleSort5(t)
    local index = 0
    for i = 1, #t - 1 do
        local isSorder = true
        for j = #t - 1, i, -1 do
            if t[j] > t[j + 1] then
                 t[j],t[j + 1] = t[j+1], t[j]
                 isSorder = false
            end
            index = index + 1
        end
        if isSorder then
            break
        end
    end
end


local list
for k,v in ipairs(keys) do
   list=Split(v,":")
   id=list[count(list)]
  result[k]=tonumber(id)
end
bubbleSort5(result)
 return result