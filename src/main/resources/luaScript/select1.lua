local tableName=tostring(KEYS[1])
local selectCondition1=tostring(ARGV[1])
local selectValue1=ARGV[2]
local selectCondition2=ARGV[3]
local selectValue2=ARGV[4]
local dbsize=redis.call("dbsize")
local myResultKeys=redis.call("scan",0,"match",tableName,"count",dbsize)
local keys= myResultKeys[2]
local j=0
local result={}
for k,v in ipairs(keys) do
  if selectValue1==redis.call("hget",tostring(v),selectCondition1) and
       selectValue2==redis.call("hget",tostring(v),selectCondition2) then
        j=j+1
        result[j]=v
  end
end
return result