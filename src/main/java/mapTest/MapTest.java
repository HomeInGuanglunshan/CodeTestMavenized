package mapTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		String total_worker_time = "SELECT top 10 qs.sql_handle query_hash,qs.creation_time,qs.last_execution_time,SUBSTRING(st.text, (qs.statement_start_offset/2)+1,((CASE qs.statement_end_offset WHEN -1 THEN DATALENGTH(st.text) ELSE qs.statement_end_offset END - qs.statement_start_offset)/2) + 1) AS statement_text,qs.total_worker_time AS total_worker_time,qs.total_elapsed_time as total_elapsed_time,qs.total_logical_reads as total_logical_reads,qs.total_logical_writes as total_logical_writes,qs.execution_count FROM sys.dm_exec_query_stats AS qs CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st ORDER BY total_worker_time DESC;";
		String total_elapsed_time = "SELECT top 10 qs.sql_handle query_hash,qs.creation_time,qs.last_execution_time,SUBSTRING(st.text, (qs.statement_start_offset/2)+1,((CASE qs.statement_end_offset WHEN -1 THEN DATALENGTH(st.text) ELSE qs.statement_end_offset END - qs.statement_start_offset)/2) + 1) AS statement_text,qs.total_worker_time AS total_worker_time,qs.total_elapsed_time as total_elapsed_time,qs.total_logical_reads as total_logical_reads,qs.total_logical_writes as total_logical_writes,qs.execution_count FROM sys.dm_exec_query_stats AS qs CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st ORDER BY total_elapsed_time DESC;";
		String total_logical_reads = "SELECT top 10 qs.sql_handle query_hash,qs.creation_time,qs.last_execution_time,SUBSTRING(st.text, (qs.statement_start_offset/2)+1,((CASE qs.statement_end_offset WHEN -1 THEN DATALENGTH(st.text) ELSE qs.statement_end_offset END - qs.statement_start_offset)/2) + 1) AS statement_text,qs.total_worker_time AS total_worker_time,qs.total_elapsed_time as total_elapsed_time,qs.total_logical_reads as total_logical_reads,qs.total_logical_writes as total_logical_writes,qs.execution_count FROM sys.dm_exec_query_stats AS qs CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st ORDER BY total_logical_reads DESC;";
		String total_logical_writes = "SELECT top 10 qs.sql_handle query_hash,qs.creation_time,qs.last_execution_time,SUBSTRING(st.text, (qs.statement_start_offset/2)+1,((CASE qs.statement_end_offset WHEN -1 THEN DATALENGTH(st.text) ELSE qs.statement_end_offset END - qs.statement_start_offset)/2) + 1) AS statement_text,qs.total_worker_time AS total_worker_time,qs.total_elapsed_time as total_elapsed_time,qs.total_logical_reads as total_logical_reads,qs.total_logical_writes as total_logical_writes,qs.execution_count FROM sys.dm_exec_query_stats AS qs CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st ORDER BY total_logical_writes DESC;";
		String execution_count = "SELECT top 10 qs.sql_handle query_hash,qs.creation_time,qs.last_execution_time,SUBSTRING(st.text, (qs.statement_start_offset/2)+1, ((CASE qs.statement_end_offset WHEN -1 THEN DATALENGTH(st.text) ELSE qs.statement_end_offset END - qs.statement_start_offset)/2) + 1) AS statement_text,qs.total_worker_time AS total_worker_time,qs.total_elapsed_time as total_elapsed_time,qs.total_logical_reads as total_logical_reads,qs.total_logical_writes as total_logical_writes,qs.execution_count FROM sys.dm_exec_query_stats AS qs CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st ORDER BY execution_count DESC;";
		Map<String, String> map = new HashMap<String, String>();
		map.put("itil_auto_defense_ms_total_worktime", total_worker_time);
		map.put("itil_auto_defense_ms_total_wastetime", total_elapsed_time);
		map.put("itil_auto_defense_ms_total_logicread", total_logical_reads);
		map.put("itil_auto_defense_ms_total_logicwrite", total_logical_writes);
		map.put("itil_auto_defense_ms_exe_times", execution_count);
		for (String map_key : map.keySet()) {
			System.out.println(map_key + "   " + map.get(map_key));
		}
	}
}
