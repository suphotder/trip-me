import { useEffect, useState } from "react";
import useFetch, { CachePolicies } from "use-http";

export const useUserViewModel = (keyword) => {
  const [trips, setTrips] = useState([]);
  const [loading, setLoading] = useState(true);

  const tripsApi = useFetch(`http://localhost:9000/api/trips`, {
    cachePolicy: CachePolicies.NO_CACHE,
  });

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      const res = await tripsApi.get(`?keyword=` + keyword);
      setTrips(res);
      setLoading(false);
    };

    fetchData();
  }, [keyword]);

  return { trips, loading };
};
