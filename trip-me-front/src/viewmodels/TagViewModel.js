import { useEffect, useState } from "react";
import useFetch, { CachePolicies } from "use-http";

export const TagViewModel = () => {
  const [tags, setTags] = useState([]);
  const [loadingTag, setLoadingTag] = useState(false);
  const tagApi = useFetch(`http://localhost:9000/api/tags`, {
    cachePolicy: CachePolicies.NO_CACHE,
  });

  useEffect(() => {
    const fetchData = async () => {
      setLoadingTag(true);
      const res = await tagApi.get(`/popular`);
      setTags(res);
      setLoadingTag(false);
    };
    fetchData();
  }, []);

  return { tags, loadingTag };
};
