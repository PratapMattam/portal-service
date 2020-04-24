package com.charters.portal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reward {
	Integer customerId;
	Integer totalRewards;
	Map<Month, Integer> rewardsByMonthly;
}
